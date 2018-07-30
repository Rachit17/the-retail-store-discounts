# The Retail Store
This spring boot application calculates the net payable amount on the basis of invoice. It has one **restful service** which is exposed via url and with correct input format renders the result.

### Basic Software Needed to run the app :
1. JDK 1.8 or later
2. Maven 3.2+
3. Git 2.13+

### How to run the app :
Install the software mentioned above if not done.

In any folder of choice, open command prompt/git terminal.

Run the following commands : 

1. git clone git@github.com:Rachit17/the-retail-store-discounts.git
2. mvn clean install spring-boot:run 
3. After all the dependencies are successfully downloaded, check the output of services in postman as per below mentioned scenarios.

#### Scenario -1 (Discount only on bill amount, no percentage based discounts)
1. **Sample Url** :
**http://localhost:8080/retailStore/invoice/** **POST** :
2. Sample Input :
{
		"invoiceId" :1,
		"userId" :4,
		"items" : [2,2],
		"amount" :100
	}
  Output : 95
  Explanation : As both items are groceries,so flat discount of 5 dollars given.
  Item Type and user role are identified by using service class methods and dummy data populated already.
  Screenshot for the above can be found in Images folder.


#### Scenario -2 (Both flat and percentage based discounts)
1. **Sample Url** :
**http://localhost:8080/retailStore/invoice/** **POST** :
2. Sample Input :
{
		"invoiceId" :1,
		"userId" :1,
		"items" : [2,3],
		"amount" :100
	}
  Output : 66.5
  Explanation : As one of the item is grocery,and user is an employee so flat discount of 5 dollars and other 30% discount       on  95 dollars is given.
   Item Type and user role are identified by using service class methods and dummy data populated already.
  
#### Scenario -3 (Both flat and percentage based(customer creation date) discounts)
1. **Sample Url** :
**http://localhost:8080/retailStore/invoice/** **POST** :
2. Sample Input :
{
		"invoiceId" :1,
		"userId" :5,
		"items" : [2,3],
		"amount" :100
	}
  Output : 90.25
  Explanation : As one of the item is grocery,and user is neither an employee nor affiliate but is an old customer for more     than two years, so flat discount of 5 dollars and other 5% discount on  95 dollars is given.
  
  There are various other scenarios tested but explained only above in interest of time.
  
  ### Assumptions :
1. Dummy data is created for users and items which is populated at start of application,can be found in UserServiceImpl and ItemService impl class and Test scenarios are based on dummy data.
2. Higher discount percentage is considered in case of chosing only one of the percentage based discounts.
3. Progressive discount concept is there like after the discount is given on amount, then next discount will be given on reduced amount.
4. If none of the items are groceries in the item set of input, than no percentage wise discount will be given but if one or all of the items are groceries, then discount is applied only once on the amount after the flat discount of 5 on every 100.
