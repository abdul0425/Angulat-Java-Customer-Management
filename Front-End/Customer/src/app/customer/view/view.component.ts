import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css'],
})
export class ViewComponent implements OnInit {
  constructor(
    private _activate: ActivatedRoute,
    private _service: CustomerService,
    private _route: Router
  ) {}

  customer!: any;

  customerId: number = this._activate.snapshot.params['id'];

  ngOnInit(): void {
    this.getCustomerById();
  }

  getCustomerId() {}

  getCustomerById() {
    this._service.getCustomerById(this.customerId).subscribe((data) => {
      this.customer = data;
    });
  }
}
