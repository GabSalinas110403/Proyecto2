import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { EmpleadoService } from '../../core/services/empleado.service';
import { PuestoService } from '../../core/services/puesto.service';
import { Puesto } from '../../core/models/puesto.model';

@Component({
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './empleado-form.component.html'
})
export class EmpleadoFormComponent implements OnInit {
  puestos: Puesto[] = [];
  idEmpleado?: number;
  
  empleado: any = {
    nombre: '',
    correo: '',
    puesto: { id: null }
  };

  constructor(
    private empleadoService: EmpleadoService,
    private puestoService: PuestoService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.puestoService.listar().subscribe(data => this.puestos = data);

    const id = this.route.snapshot.params['id'];
    if (id) {
      this.idEmpleado = +id;
      this.empleadoService.obtenerPorId(this.idEmpleado).subscribe(data => {
        this.empleado = data;
      });
    }
  }

  guardar() {
    if (this.idEmpleado) {
      this.empleadoService.actualizar(this.idEmpleado, this.empleado).subscribe(() => {
        this.router.navigate(['/']);
      });
    } else {
      this.empleadoService.crear(this.empleado).subscribe(() => {
        this.router.navigate(['/']);
      });
    }
  }

  cancelar() {
    this.router.navigate(['/']);
  }
}