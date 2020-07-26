# advanced-programming-spring-2020-project-reddit

## AP Course Project: Reddit
This is a description for Shiraz University's Advanced Programming 2020 Spring Course, which was decided and planned to be system similar to Reddit.

### Project Overview
As a project for this course of AP, the gradery team has decided that a system similar to **Reddit** to be compeletely impleneted (Back-end and Front-end). This project is only intended as a good practitcal experience for the students and is **not mandatory**. Those who participate and carry out this project are given *bonus scores and recommendations from the gradery team to the instructor directly*. Even though such bonuses are proportional to the level or scale of implenetation, all efforts are appreciated; so please do participate!

### Submission
To provide the individuals participating with *an experience for working with Git*, *Forking*, *Contributing to existing repositories on GitHub thorugh Pull Requests (the way Open-Source projects are done)*, the team has decided that this repository will act as the main and source repo, and to participate and implement the project, you would have to **fork this repo**, work on it (according to the workflows that you would have to read about, such as Fork-and-Branch), and in the end **submit a Pull Request to this repo**; so that the team would then examine the requests (with probably presentation from yourselves) and then grade them accordingly.<br /> Best PR would then be decided by the team and would be merged with this repo (which would reamin as a good history for you, retaining your name and project for your own personal work history). Keep in mind that **the PRs would not be removed**, and they will also be kept in the history of this repo; So even if your PR is not merged with the mater of this repo, your project and your request would still be available in this repo and would be a great refernce point in your work history.<br/>

Note: *Only PRs from students of this course are accepted.*

### Project Requirements
As said before, this project is intended to be simliar to Reddit, so any feature that is now available on Reddit, if implemented, is a step towards our goal, though *not all features are necessary for an acceptable submission*.<br />
With that being said, we think that the system should support the following description and requirements (for further questions into the features, see how reddit currently supports those - [Reddit](https://www.reddit.com/)):
In this system, we have four main components: **User**, **Subreddit**, **Post**, and **Comments**.

#### User
Our system should have Users (Redditors) and also have a user management system (login and signup). Users can follow and message eachother. They should also have the ability to own and join a Subreddit (Optional: they can also be appointed as a Mod (Moderator) of a Subreddit or if owner, appoint one). Users can also post in Subreddits they own or have joined.

#### Subreddit
Each Subreddit has a name and a description (Optional: also a picture). Each Subreddit contains a number of Posts which are posted by the users of that Subreddit.

#### Post
Each Post has a title. The Post's content can be text, image or both text and image (Image is Optional). Posts can also be shared with other users. Each post has a score assigned to it (initially zero). Also, each post can be either *Upvoted* or *Downvoted* by a user. When upvoted, the score is incremented (Score + 1). When downvoted, the score is decremented (Score - 1). Also each post has a number of Comments.

#### Comment
Each comment has a content, which is text. Comments also have a score system just like posts (Upvotes & Downvotes). Each comment can be replied to. The replies also have the same properties as comments so they can also be replied and given a score.


#### Searching
The system should support searching for a subreddit, a post *in a subreddit*, and a user. For more info on how it's done, visit Reddit.


#### Pages
The system should support the following pages in its user interface: Login/Signup Page, Home Page, Subreddit Page, Post Page.
A brief description of the content of such pages is as follows:
- Login/Signup Page
	A regular login or signup page to support such features
- Home Page
	Shows all of User's followed Subreddits' top Posts by score (Optional: add sort by recent, hot, and etc.)
- Subreddit Page
	Subreddit's Posts by score (Optional: again sorting the posts)
- Post Page
	Post's title, text (and image if supported), and comments (Try to show comments and their replies as threads) 


### Project's User Interface
The User Interface for the project is totally up to you. Two main options that we can think of are **Text User Interface (TUI, Terminal)** & **JavaFX**. The team suggests that you use JavaFX, due to its ease and the great tools that it provides you with to make a high-level UI for desktop and mobile apps, though its learning is *primarily up to you*.


<br /><br />
Good luck on your future endeavors!<br />
Gradery Team of AP Spring 2020, Shiraz University<br />
Amir Mohammad Tavakkoli<br />
Mohammad Hossein Allahakbari<br />
Amir Masoud Baghi<br />
Aref Sayareh<br />
