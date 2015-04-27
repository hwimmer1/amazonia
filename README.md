# java-counterfeit-servlet

A rework of the java-getting-started Heroku template to allow Dr. Wimmer's counterfeit detection library to receive Amazon reviews, perform detection functions, and respond with a counterfeit score.

This application support the [Getting Started with Java on Heroku](https://devcenter.heroku.com/articles/getting-started-with-java) article - check it out.

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

