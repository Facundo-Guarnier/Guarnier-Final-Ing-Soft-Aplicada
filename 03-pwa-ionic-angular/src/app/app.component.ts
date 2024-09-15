import { Component } from '@angular/core';
// import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent {
  public appPages = [
    { title: 'Mi Perfil', url: '/folder/mi-perfil', icon: 'person' },
    { title: 'Usuarios', url: '/folder/usuarios', icon: 'people' },
    { title: 'Autores', url: '/folder/autores', icon: 'person-circle' },
  ];
  constructor(
    // private authService: AuthService
  ) {}

  loadJWT() {
    // this.authService.login().subscribe(
    //   (response) => {
    //     // Aquí puedes guardar el JWT en el almacenamiento local si lo deseas
    //     localStorage.setItem('jwt', response.id_token);
    //   },
    //   (error) => {
    //     console.error('Error al cargar JWT:', error);
    //   }
    // );
  }
}
