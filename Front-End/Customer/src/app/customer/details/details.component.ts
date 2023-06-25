import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/customer/customer.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css'],
})
export class DetailsComponent implements OnInit {
  constructor(private _service: CustomerService, private _router: Router) {}

  customers_list!: Array<any>;

  ngOnInit(): void {
    this._service.getCustomersList().subscribe(
      (data) => {
        this.customers_list = data;
      },
      (error) => console.error
    );
  }

  goToUpdate(id: number) {
    this._router.navigate(['update', id]);
  }

  goToView(id: number) {
    this._router.navigate(['view', id]);
  }

  deleteCustomer(id: number) {
    this._service.deleteCustomer(id).subscribe((data) => {});
  }
}
