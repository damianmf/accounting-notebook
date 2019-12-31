import {Component} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Accounting notebook';
  private baseUrl: string = "http://localhost:8080/api/";
  transactions:any[] = [];
  transactionsDetail:{} = {};

  constructor(private httpClient: HttpClient){
    this.getTransactions();
  }

  private getTransactions() {
    this.httpClient.get(this.baseUrl + "transactions")
      .subscribe((res:any)=>{
          console.log(res);
          this.transactions = res;
        },
        err => alert(JSON.stringify(err)),);
  }

  private getTransaction(id) {
    if(!this.transactionsDetail[id]){
      this.httpClient.get(this.baseUrl + "transactions/" + id)
        .subscribe((res:any)=>{
            console.log(res);
            this.transactionsDetail[id] = res;
          },
          err => alert(JSON.stringify(err)),);
    }
  }

}
