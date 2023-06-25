import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  constructor(private _service:CustomerService,
    private _route : Router) { }

  ngOnInit(): void {
  }

  createCustomer(customer:any){
    this._service.createCustomer(customer.value).subscribe((data)=>{
      console.log(data);
    })
    this.goToDetails();
  }

  goToDetails(){
    this._route.navigate(['details'])
  }

}
