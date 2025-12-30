import { Routes } from '@angular/router';
import { EmpleadosComponent } from './pages/empleados/empleados.component';
import { EmpleadoFormComponent } from './pages/empleados-form/empleado-form.component';
import { NominaComponent } from './pages/nomina/nomina.component';

export const routes: Routes = [
    { path: '', redirectTo: 'empleados', pathMatch: 'full' },
    { path: '', component: EmpleadosComponent },
    { path: 'nuevo', component: EmpleadoFormComponent },
    { path: 'editar/:id', component: EmpleadoFormComponent },
    { path: 'nomina/:id', component: NominaComponent }
];
