import { Component, OnInit } from '@angular/core';
import { ApiClientService } from './api-client.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  helloWorldText: string;
  constructor(private apiClient: ApiClientService) {}

  ngOnInit() {
    this.apiClient.getHelloWorld().subscribe(text => this.helloWorldText = text);
  }
}
