import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.development';
import { Statement } from './models/statement';

@Injectable({
  providedIn: 'root'
})
export class StatementService {

  api: string;

  constructor(private http: HttpClient) {
    this.api = environment.apiBaseUrl + "statement";
  }

  getCurrentMonthStatement(ano: number): Observable<Statement> {
    return this.http.get<Statement>(this.api + "/" + ano + "/currentMonth");
  }

  getCurrentYearStatement(ano: number): Observable<Statement> {
    return this.http.get<Statement>(this.api + "/" + ano + "/currentYear");
  }

  getAnnualStatement(ano: number, year: number): Observable<Statement> {
    return this.http.get<Statement>(this.api + "/" + ano + "/" + year);
  }

  getMonthlyStatement(ano: number, year: number, month: string): Observable<Statement> {
    return this.http.get<Statement>(this.api + "/" + ano + "/" + year + "/" + month);
  }
}
