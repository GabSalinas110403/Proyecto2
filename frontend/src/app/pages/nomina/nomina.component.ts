import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { NominaService } from '../../core/services/nomina.service';
import { Nomina } from '../../core/models/nomina.model';

@Component({
  standalone: true,
  imports: [CommonModule],
  templateUrl: './nomina.component.html'
})
export class NominaComponent implements OnInit {

  nomina!: Nomina;

  constructor(
    private route: ActivatedRoute,
    private nominaService: NominaService
  ) {}

  ngOnInit() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.nominaService.calcular(id).subscribe(data => {
      this.nomina = data;
    });
  }
}
