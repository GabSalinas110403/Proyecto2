import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Nomina } from '../models/nomina.model';

@Injectable({ providedIn: 'root' })
export class NominaService {

  private apiUrl = 'http://localhost:8080/api/nomina';

  constructor(private http: HttpClient) {}

  calcular(empleadoId: number) {
    return this.http.get<Nomina>(`${this.apiUrl}/${empleadoId}`);
  }
}
