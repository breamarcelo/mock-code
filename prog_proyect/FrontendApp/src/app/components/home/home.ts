import { Component, OnInit, signal } from '@angular/core';
import { GoogleMap, GoogleMapsModule } from '@angular/google-maps';

@Component({
  selector: 'app-home',
  imports: [GoogleMapsModule],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home {
  center: google.maps.LatLngLiteral = { lat: 47, lng: 12 };
  zoom = 10;
  lang = "es-ES"

}
