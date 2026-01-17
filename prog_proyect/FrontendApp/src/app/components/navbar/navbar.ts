import { Component } from '@angular/core';
import { MatToolbarModule, MatToolbar } from '@angular/material/toolbar';
import { MatButtonModule, MatIconButton } from '@angular/material/button';
import { MatIconModule, MatIcon } from '@angular/material/icon';

@Component({
  selector: 'app-navbar',
  imports: [MatToolbar, MatIconButton, MatIcon],
  templateUrl: './navbar.html',
  styleUrl: './navbar.css',
})
export class Navbar {

}
