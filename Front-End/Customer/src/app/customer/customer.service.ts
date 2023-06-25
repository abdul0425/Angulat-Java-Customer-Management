import { FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CustomerService {
  constructor(private _http: HttpClient) {}

  public getCustomersList(): Observable<any> {
    return this._http.get('http://localhost:9090/api/getAll');
  }

  public createCustomer(customer: any): Observable<any> {
    return this._http.post('http://localhost:9090/api/create', customer);
  }

  public getCustomerById(id:number){
    return this._http.get(`http://localhost:9090/api/${id}`);
  }

  public updateCustomer(id:number,customer:any):Observable<any>{
    return this._http.put(`http://localhost:9090/api/update/${id}`,customer)
  }

  public deleteCustomer(id:number){
    return this._http.delete(`http://localhost:9090/api/delete/${id}`)
  }
}
