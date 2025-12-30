import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Concepto } from '../models/concepto.model';

@Injectable({ providedIn: 'root' })
export class ConceptoService {

  private apiUrl = 'http://localhost:8080/api/conceptos';

  constructor(private http: HttpClient) {}

  listar() {
    return this.http.get<Concepto[]>(this.apiUrl);
  }
}
