import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SupervisorHubService } from '../supervisor-hub.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private adminservice:SupervisorHubService, private router:Router) { }

  ngOnInit(): void {
    this.router.navigate(["home"]);

  }


}
