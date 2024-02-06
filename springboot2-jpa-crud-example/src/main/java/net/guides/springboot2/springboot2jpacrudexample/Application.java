package net.guides.springboot2.springboot2jpacrudexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	//	E:\chr1\angularmain\angular-frontend>ng serve --port 4300 --open
	//	E:\chr1\angularmain\angular-frontend>ng serve
	//	E:\chr1\angularmain\angular-frontend>ng serve
	//	http://localhost:4200/employees
	//	http://localhost:4200/add
		
		
	}
}


//import { Component } from '@angular/core';
//
//@Component({
//  selector: 'your-component',
//  templateUrl: 'your-component.component.html',
//})
//export class YourComponent {
//  product = {
//    quantity: 0,
//    price: 0
//  };
//  total = 0;
//
//  calculateTotal() {
//    this.total = this.product.quantity * this.product.price;
//  }
//}

//==================================
//<div class="form-group">
//<label for="name">First Name</label>
//<input type="text" class="form-control" id="quantity" required [(ngModel)]="product.quantity" name="quantity" (ngModelChange)="calculateTotal()">
//</div>
//
//<div class="form-group">
//<label for="name">Last Name</label>
//<input type="text" class="form-control" id="price" required [(ngModel)]="product.price" name="price" (ngModelChange)="calculateTotal()">
//</div>
//
//<div class="form-group">
//<label for="name">Total</label>
//<input type="text" class="form-control" id="total" required [(ngModel)]="total" name="total">
//</div>
//
//<button type="submit" class="btn btn-success">Submit</button>


