## Distribited Systems Project
###### Written by Conor McGrath

Outlined below are instructions on how to use the project files contained within this repository.

---

### Thechnologies Used
The technologies I'm using in this project are:

    1. Eclipse Java EE
    2. Apache Tomcat
    3. Postman
    4. Wampserver64

---

## How to use this repository

1. Ensure you have Java 1.8, Apache Tomcat 9.0, Postman API, Java EE plugin for Eclipse
2. Enter the following commands into your command line.

---

#### Getting set up
```
##### Change directory to anywhere you desire
cd anywhere..

##### Clone this repository using git
git clone https://github.com/conormc93/ds-Project.git
cd ds-Project-master

##### Run the commands in descending order in "order_table.sql"
This will generate the tables and insert values into them for testing purposes.

##### Open up Eclipse & make sure you are in Java EE perspective
In eclipse go to File -> Import -> General -> Projects from Folder/Archive
Select the directory "..\ds-Project-master\Project"

##### Add a new server
In eclipse, go to the servers tab where the console is located.
Add a new server and choose Apache -> v9.0 -> choose directory where Apache Tomcat v9.0 was installed lcoally

##### Fix build path errors
The next step is to right click on "dsProject" and go to Build Path -> Configure Build Path

##### Add mysql connector
Right click RMIServer -> Build Path -> Configure Build Path 
Make sure all boxes are selected and hit "Apply and Close"

```

---

#### Testing the application
```
##### Right click on RMIServer
RMIServer -> Run as -> Java Application
Wait for the output "Server Ready."

##### Right click on dsProject
dsProject -> Run as -> Run on Server
Wait a few moments and you will be brough to the index.jsp page.

##### Get all orders
You can follow the link "Get all orders"
This will return an xml representation of the orders currently in the database

```

---

### Using Postman
I tested my CRUD functionality using the Postman API.

#### Delete Order
![delete](https://i.imgur.com/UYMBQEv.png)

#### Update Order
![update](https://i.imgur.com/XLuPuII.png)

#### Create Order
![create](https://i.imgur.com/7AaN1Nq.png)

#### Read Orders
![read](https://i.imgur.com/mphdWFK.png)

---

### Known Bugs
When running the RMIServer on my laptop I get the following error:

![error](https://i.imgur.com/undefined.png)

I had this issue throughout the module. I still haven't understood what causes this error but I have worked around the issue by turning my WiFi off when running the RMIServer.

---

### Conclusion
I enjoyed working on this project, although I ran into a lot of issues along the way. 

I took a lot of experience from creating the application itself, and will endeavour to apply these technologies used in the future.

I would definitely like to see how I could continue working on this application as I feel I only started to understand how it worked within the final couple of weeks. 

If I managed my time better I would have developed the Web Client a lot better and would have possibly made time for the extra features outlined in the project.pdf.

All in all, I am happy with the attempt I made and can take away valuable experienece working with Java RMI, JAX-RS/Jersey, Postman etc.



