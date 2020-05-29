import { Component, OnInit } from '@angular/core';
import { CartService } from '../cart.service'
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  items;
  checkoutForm;

  constructor(private cartService: CartService, private formBuilder: FormBuilder) {
    this.items = cartService.getItems();
    this.checkoutForm = this.formBuilder.group({
      name: '',
      address: ''
    });
  }

  ngOnInit() {
  }

  onSubmit(customerData) {
    console.warn('你的订单已提交', customerData);
    //清空购物车
    //如果是真实购物车，还会有向服务器提交数据的过程
    this.items = this.cartService.clearCart();
    this.checkoutForm.reset();
  }

}