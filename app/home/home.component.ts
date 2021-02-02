import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  flag:number;
  constructor() { }

  ngOnInit(): void {
  }

  clickValue(){
    console.log("number to click"+this.flag);
  }

}
