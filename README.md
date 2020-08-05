# MoviesDatabase

his is a guide only - it does not include everything you need to complete this project but I hope it helps.

Be sure to refer to the rubric a checklist for what you should have achieved in this project.

The DatabasePreview the document
Design the database
Create a Spring Starter Project with
Web
Thymeleaf
Database
JPA
H2
     spring.h2.console.enabled=true
     spring.h2.console.path=/h2 (or leave as the default)
Create a class for each of the tables in your database using some or all of the following annotationsPreview the document
@Entity
@ManyToOne, @OneToOne, @OneToMany
@Id
@GeneratedValue
@Column
@Column(nullable=false, unique=true)
@JoinColumn
@OnDelete(action = OnDeleteAction.CASCADE)
Do this iteratively i.e. create a table without a relationship then launch your program. Take a look at the database through

localhost:8080/h2 
and you should see that the table has been created.
Now add more tables and establish relationships, constantly testing to make sure the database has been created.

Create a repository for each of the classes by extending the JpaRepository class.
Add extra methods later in the project as you need them through the generation of queries by named queries (Links to an external site.) or by using @Query to create your own queries e.g. the following method's signature extends the JpaRepository class to add a method that edits the director's name, given the director's id in the database. This is based on JPQL.
@Transactional
@Modifying
@Query("UPDATE Director AS d SET d.directorName = :newName WHERE d.directorId = :directorId")
void editDirectorsName(String newName, int directorId);
Create a service layer in case you need to add some business rules at a later stage.
Add a service interface for each class
Add a service implementation for each class
Load data into the database using either a data loader class (extending ApplicationRunner) or adding code to the main class (extending CommandLineRunner), but in both cases implementing the run() method, using the save() method from the service layer.
The Controllers (MVC)Preview the document
Create a homepage in HTML. Nothing fancy and no Thymeleaf.
Create an index controller in a new @Controller class in a suitable package i.e. a get controller that returns the template's name (HTML page name) as a String.
Create a controller to show all the films.  The user might type http://localhost:8080/films (Links to an external site.) to see a webpage that lists the projects' details.
       The controller should

Have a Model parameter
Use the project's service layer to access all the films from the database, returning a list of films
Add this list to the model
Return the view as a String
      The view should use Thymeleaf to

Iterate through the list of objects extracting
Display the fields of the object on the page in some suitable format. Read 11-Spring Web and Databases.pdfPreview the document for more information and examples.
Create a controller to show one project based upon its id.
The user might type http://localhost:8080/project/4
to see the project with id # 4.
The controller should
Have a @PathVariable parameter for the id
Have a @Model parameter to send data to the view
Use the project's service layer to access a particular project by id 
Add this project to the model
Return the view as a string
The View should use Thymeleaf to display the details about the project in a suitable format.

This is not a full list of controllers, but it gets you started. 

Forms and form validationPreview the document
Decide on what data you are trying to gather from the user and create a class for this form.
Create a Get controller which
receives a Model object as a parameter
adds a suitable object, for gathering form data, to the model. This might be instantiated from an existing class or from a dedicated class e.g. NewUserForm
returns the view (form to register a user) as a String
Create a HTML form 
Use th:object to connect the form to the object (form binding).
Use th:field to connect the form's fields to the object's properties/fields.
Use th:action to define the action e.g. th:action="@{/registerUser}"
Create a POST controller which
Receives the form's data (the bound object) as a parameter
Use the service layer to save this user or deal with any arising issues e.g. duplicate user
Return the home page as a String (you can change this "success" page later)
Add annotations to the form's class where appropriate, these might be
@NotEmpty
@Size(min=??, max=???)
@Email
Full list of Java Constraints (Links to an external site.)
FYI - extra constraints from Hibernate (Links to an external site.)
In the Post controller
add @Valid to the (parameter) object
add BindingResult binding as an extra parameter
add an if statement
if (binding.hasErrors())
which should return the view again if the user has made a mistake
the rest of the code stays as it was.
Test this by providing wrong data e.g. leave name fields empty.
  But we would like error messages to tell the user what they have done wrong.

In the view, add code such as the following to conditionally display the error message
<span th:if="${#fields.hasErrors('userName')}">ERROR MESSAGE</span>
InternationalisationPreview the document
Create a new Configuration-annotated class that extends the WebMvcConfigurer containing the only boilerplate code you will need for this project:
      @Bean
      public LocaleChangeInterceptor localeChangeInterceptor() {
            LocaleChangeInterceptor lci= new LocaleChangeInterceptor();
            lci.setParamName("lang");
            return lci;
      }  

      @Override
      public void addInterceptors(InterceptorRegistry registry) {
	   registry.addInterceptor(localeChangeInterceptor());
      }

      @Bean
      public CookieLocaleResolver localeResolver() {
            CookieLocaleResolver localeResolver= new CookieLocaleResolver();
            localeResolver.setDefaultLocale(Locale.UK);
            return localeResolver;
      }
Create a file called messages.properties in src/main/resources which will hold messages (text) for the default languages ie. UK English.

        Write the following message into that file:

index.welcome=Welcome
Create a file called, for example, messages_FR.properties which will hold the messages (text) for French.
Write the following message into that file:
index.welcome=FR_Weclome_FR
     (I know this isn't French but it saves you having to translate everything if you just do it this way).

Modify your index page to use this text by writing:
th:text="#{index.welcome}"
        which might be written in a H1 tag as a span tag – wherever you want!

Add links on the index page to allow you to change language. These links might be:
<footer>
  <a th:href="@{/} + '?lang=fr'">FRENCH</a>
  <a th:href="@{/} + '?lang=ie'">ENGLISH</a>
</footer>
That is it – you can now internationalise each page by adding th:text="#{message_key}" to keys in the messages fields as appropriate.
So far?
If you have followed the instructions above you now have

an in-memory database and associated domain
Thymeleaf view to present single and multiple data to the user
Controllers that send data to views
Controllers that receive data from views and act upon the data received (save)
Internationalisation
Form validaton
At this stage it should be easy to add other functionality and to provide two REST API endpoints that return JSON (no views), followed by a separate application to demonstrate how these endpoints might be used (no CSS required, just demonstrate how data from one application is retrieved and displayed be a second application).

Once you have worked on the project for a while you should be able ready for security.

SecurityPreview the document
Create a Role class, annotating so that it is part of the database. Populate the role table. 

Establish a relationship between a user and a role. Edit the data loader to include this extra field.

Add the security to the project using the pom file.

To use Thymeleaf sec:authorize in HTML, add

<!-- https://mvnrepository.com/artifact/org.thymeleaf.extras/thymeleaf-extras-springsecurity3 -->
<dependency>
<groupId>org.thymeleaf.extras</groupId>
<artifactId>thymeleaf-extras-springsecurity3</artifactId>
<version>3.0.4.RELEASE</version>
</dependency>
to the pom file and edit the HTML tag of each HTML file to be

<html xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">.
Create a security configuration file starting by adding no security checks for any user then add authentication for certain pages and authorisation for other pages. 

Add authorisation/authentication to the consumer application. 

You should use security in the views to restrict what the user can see. The following code snippet shows the login button to unauthorised users (not logged in), and the logout button to authorised users (already logged in)

<span sec:authorize="!isAuthenticated()"><a th:href="@{/login}">Login</a></span> 
<span sec:authorize="isAuthenticated()"><a th:href="@{/logout}">Logout</a></span>
