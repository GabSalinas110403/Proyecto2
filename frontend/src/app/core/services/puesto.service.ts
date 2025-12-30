import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Puesto } from '../models/puesto.model';

@Injectable({ providedIn: 'root' })
export class PuestoService {

  private apiUrl = 'http://localhost:8080/api/puestos';

  constructor(private http: HttpClient) {}

  listar() {
    return this.http.get<Puesto[]>(this.apiUrl);
  }
}
