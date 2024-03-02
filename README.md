## Stella TypeCheck

Typechecker for [Stella](https://fizruk.github.io/stella/) written in Scala

## Build

Latest build is available in Actions

To build locally:

```sh
sbt assemble
```

Jar file will be generated in `target/`

## Test

To run all tests:

```sh
sbt test
```

To run specific test (error tag / test name):

```sh
sbt test -n test_to_include -l test_to_exclude
```

## Run

Typecheck specific file:

```sh
sbt run file
```
