import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { EmpleadoService } from '../../core/services/empleado.service';
import { Empleado } from '../../core/models/empleado.model';
import { ChangeDetectorRef } from '@angular/core';

@Component({
  standalone: true,
  imports: [CommonModule],
  templateUrl: './empleados.component.html'
})
export class EmpleadosComponent implements OnInit {

  empleados: Empleado[] = [];

  constructor(
    private empleadoService: EmpleadoService,
    private router: Router,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit() {
    this.empleadoService.listar().subscribe(data => {
      this.empleados = data;
      this.cdr.detectChanges();
    });
  }

  eliminar(id: number) {
    this.empleadoService.eliminar(id).subscribe(() => {
      this.ngOnInit();
    });
  }

  nuevo() {
    this.router.navigate(['/nuevo']);
  }

  verNomina(id: number) {
    this.router.navigate(['/nomina', id]);
  }

  editar(id: number) {
  this.router.navigate(['/editar', id]);
}
}
