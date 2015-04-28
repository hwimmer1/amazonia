# java-counterfeit-servlet

A rework of the java-getting-started Heroku template to allow Dr. Wimmer's counterfeit detection library to receive Amazon reviews, perform detection functions, and respond with a counterfeit score.

## What's Next:
- Rebuild ScoreDetector.jar to write a textfile, then read the textfile contents
- Test file writing functionality in Heroku
- Maybe include empty text file with repo, have main.java edit the file

## Downloading and Installing

```sh
$ git clone https://leonidkukuyev@bitbucket.org/leonidkukuyev/java-counterfeit-servlet.git
$ cd java-counterfeit-servlet
$ mvn install
```

## Running Locally on Linux

Make sure you have Java and Maven installed.  Also, install the [Heroku Toolbelt](https://toolbelt.heroku.com/).

```sh
$ foreman start web
```

## Running locally on Windows

```sh
$ foreman start web -f Procfile.windows
```

Your app should now be running on [localhost:5000](http://localhost:5000/).

## Compiling Changes to Java Source

```sh
$ mvn compile
```

## Deploying to Heroku

```sh
$ heroku create
$ git push heroku master
$ heroku open
```

## Documentation

For more information about using Java on Heroku, see these Dev Center articles:

- [Java on Heroku](https://devcenter.heroku.com/categories/java)

