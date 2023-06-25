import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css'],
})
export class UpdateComponent implements OnInit {
  constructor(
    private _service: CustomerService,
    private _router: Router,
    private _activate: ActivatedRoute
  ) {}

  customerId: number = this._activate.snapshot.params['id'];
  customer!: any;

  ngOnInit(): void {
    this.getCustomerById();
  }

  getCustomerById() {
    this._service.getCustomerById(this.customerId).subscribe((data) => {
      this.customer = data;
    });
  }

  updateCustomer(customer: any) {
    this._service
      .updateCustomer(this.customerId, customer.value)
      .subscribe((data) => {});
    this.goToDetails();
  }

  goToDetails() {
    this._router.navigate(['details']);
  }
}
