export class Customer {

    constructor(public company_id:number,
        public company_name:string,
        public login_id:string,
        public password:string,
        public customer_name:string,
        public designation:string,
        public email_id:string,
        public address_line_1:string,
        public address_line_2:string,
        public city:string,
        public state:string,
        public pincode:number,
        public company_tel:string,
        public company_fax:string,
        public holding:string,
        public customer_tel:string,
        public customer_mob:string,
        public vat_no:string,
        public pan_no:string)
        {
        
        }
}
