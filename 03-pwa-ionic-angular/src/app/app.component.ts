import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent {
  public appPages = [
    { title: 'Mi Perfil', url: '/folder/mi-perfil', icon: 'person-circle' },
    { title: 'Usuarios', url: '/folder/usuarios', icon: 'people' },
    { title: 'Autores', url: '/folder/autores', icon: 'people' },
  ];

  constructor(
    private http: HttpClient
  ) {}

  loadJWT() {
    console.log('Cargando JWT...');
    this.login().subscribe(
      (response) => {
        localStorage.setItem('jwt', response.id_token);
        console.log('JWT cargado:', response.id_token);
      },
      (error) => {
        console.error('Error al cargar JWT:', error);
      }
    );
  }

  private login(): Observable<any> {
        const credentials = {
          username: 'admin',
          password: 'admin'
        };
        return this.http.post('http://localhost:8080/api/authenticate', credentials);
      }
}
