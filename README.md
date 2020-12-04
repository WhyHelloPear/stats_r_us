# OOAD Project

### Data source: https://github.com/chadwickbureau/baseballdatabank/tree/master/core

HW4 Summary: https://docs.google.com/document/d/1KaLtAzs-iF1KiVXu36pwWANQBRaz6lLwOAewJ1m7U6g/edit

HW5 Summary: https://docs.google.com/document/d/1gcwlO4tlB0L5lGjwmeDBQxFFsxa2p_I-Qqb1uDtQTiw/edit

HW6 Summary: https://docs.google.com/document/d/1cZAF9Ue68Z40LzQ_Wmj9HY7xlBLuu_iXZzvNH9SXT6Y/edit?ts=5fca4307

NOTE: Keep this readme file; this will be used throughout the project to document progress.

The Semester Project
Create a non-trivial set of classes and services that make use of some of the design patterns we cover to provide a nice set of functionality to the end-user; we like to see some UI design and data handling, but your project may vary. You may use any languages, frameworks, libraries, or utilities for your project as long as the project demonstrates object-oriented design.

Project 4 asks you (and your team) to engage in analysis and design activities for your semester project. You will generate a detailed set of tasks that can be accomplished with your proposed system and provide a comprehensive design of that system. The goal of these analysis and design activities is to generate information that will allow you to start implementing the system with confidence.
While I am asking for a non-trivial amount of information, you should only generate the information you need to achieve your desired functionality given the size of your team. You will have a about four weeks to develop your system (2 iterations consisting of about 2 weeks each).

During each iteration, each member of your group should expect to work on one to two use cases (possibly with other teammates). As a result, if you are a member of a two-person team, you'll want to target 4-8 use cases for your system. A 3-person team is looking at 6-12 use cases (12 is a lot!).

Use these guidelines to scope the work of this assignment and really focus on generating information that will guide your implementation efforts during the last part of the semester.

### Project Summary
<ul>
  <li>What is the project called?</li>
  <li>Who is on your team (include all names)?</li>
  <li>What is the high-level overview of your project? What are you trying to accomplish? What will your system do when you are done?</li>
</ul>

### Requirements
<ul>
  <li>Based on the project summary, what are the requirements and responsibilities for your system? List the requirements and their associated responsibilities in this section. Identify the main goals of the system and its associated responsibilities.</li>
  <li>This list may be short, but it should attempt to convey the “big picture” view of your system and what it is trying to accomplish.</li>
  <li>The requirements can include functional capabilities (what it can do), constraints (such as platforms, number of users, etc.), and non-functional characteristics (performance, security, usability, etc.).</li>
</ul>
  
### Users and Tasks: Use Cases (text or UML Diagrams)
<ul>
  <li>How many different types of users will your system have? What tasks do they need to accomplish with your system?</li>
  <li>Document how the system will support each task by providing a use case (text or UML).</li>
  <li>Try to think of the various problems or variations that can occur while trying to accomplish these tasks and document them in the use case.</li>
  <li>Remember the WAVE rule when examining your use cases.</li>
</ul>

### UML Activity Diagram
<ul>
  <li>Pick your most complex use case and create a UML Activity diagram that documents the possible paths through it.</li>
  <li>Typically, one activity diagram corresponds to a single use case, but if you decide to combine multiple use cases into a single activity diagram that's fine too.</li>
  <li>Draw a (non-UML) diagram that shows the architecture of your system. Is it a web app? A mobile app? Does your mobile app interact with a web service? Does your web app interact with both desktop and mobile clients? etc.</li>
  <li>This diagram will be a boxes-and-arrows diagram that shows the various architectural components of your system (devices, databases, 3rd party services, etc.) at a high level. See examples of Architecture Diagrams in the UML lecture.</li>
  <li>If you're building a web service or application, what frameworks will you be using, how will your service be structured, what request-response cycles will your service be supporting, etc.</li>
  <li>The goal of this task is to get you to delve more deeply into the elements you'll be using to implement your system and to think up front about what services in those elements are the most relevant to your application.</li>
  <li>Note: not all system information has to be conveyed in the diagram, you can augment the diagram with a text description or comments that go into the details more thoroughly if needed.</li>
</ul>
  
### Data Storage
<ul>
  <li>Discuss how you will persist data in your application. What storage technology will you use? Text files? XML? CSV? MySQL? Where will the data be stored? Describe the classes that you will use to access this data at run-time. A diagram of tables and relations (like an ER diagram, or something less formal) or the classes that will manage data may be used here.</li>
</ul>
  
### UI Mockups/Sketches
<ul>
  <li>Create screen mockups for the user interface of various parts of your application. What will auser see as they work through the tasks identified in your use cases? What is the overall organization of your user interface? How will data be displayed? How will the user navigate from screen to screen?</li>
  <li>Use this task as a means for focusing your thoughts about what you will actually be creating... iterate now on how your screens will be laid out and then include your final sketches in this section.</li>
  <li>There is no fixed number of screen sketches. Include what you think is needed to convey an overall sense of your application. Note: it is okay to work on paper for this task and then scan in your work to include in your document. For an automated tool, I highly recommend Balsamiq at https://balsamiq.com/</li>
</ul>

### User Interactions/UML Sequence Diagrams

<ul>
  <li>Use your use cases and UI mockups to identify at least three interactions that your user will have with your application. (If your system is more about modelling internal interactions than external user ones, this should be used to model those interactions.)</li>
  <li>For each interaction provide both a text description of how your system will support it and a UML sequence diagram of the objects that will participate in the interaction.</li>
  <li>Some of these objects will represent UI widgets, some will be model objects used to access/update persistent data, and some will be objects that sit in between the UI and the persistent data. This latter class of object is known as a controller and they contain application logic that decides how to respond to events, updating both model objects and UI widgets to represent the new state of the system.</li>
  <li>Recall that sequence diagrams do not contain conditional constructs, so be sure to clearly describe the interaction that is being displayed in the sequence diagram. Do not try to show ifthen-else scenarios in a single sequence diagram. If you find yourself needing to show such a situation, simply create two sequence diagrams, one that shows the normal branch and one that shows the off-normal branches.</li>
</ul>


### UML Class Diagram & Pattern Use
<ul>
  <li>Create a detailed class diagram that documents everything you have discovered in your design activities with respect to what classes your system will contain: what relationships they have, what are their attributes and (public) methods, what design patterns are used, etc.</li>
  <li>If it is too difficult to fit everything into a single diagram, you can split your classes across more than one diagram in whatever way makes the most sense for your application.</li>
  <li>Clearly this project is a great opportunity for looking for some experience reuse from the OO patterns library. Ideally, include at least three patterns as part of your project design. However, if you have difficulty identifying pattern use for your application, please reach out to class staff for guidance or further discussion of the requirement.</li>
  <li>For this delivery, you should include your concepts around using applicable patterns in your UML Class Diagram for the system above and highlight the patterns in the diagram.</li>
  <li>In your final delivery you will be asked to document and discuss what OO patterns or variations you considered or used, and how they impacted your design.</li>
</ul>
