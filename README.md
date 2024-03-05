# AparTechnologies-Assignment

Below are the details of my submission for the assignment, outlining the enhancements and additions made to the provided
boilerplate code to meet the requirements for Version 2 (V2) of the **String Reply Service**.

For reference, you can find the original assignment information [here](Assignment.md).

## Added Implementation Details

In completing the assignment, I have extended the provided boilerplate code to meet the requirements for Version 2 (V2)
of the **String Reply Service**. Here's a breakdown of the enhancements and additions:

### New Endpoint for V2

I implemented a new endpoint `/v2/reply/{rule}-{string}` to accommodate the updated requirements for Version 2 of the
service. This endpoint accepts a rule and a string separated by a dash (-), where the rule specifies the operations to
be performed on the string.

#### Rule and String Validation

The endpoint ensures that the provided rule adheres to the specified format, which consists of two numbers representing
the string operations. Additionally, the input string is validated to ensure it meets the expected criteria.

Any invalid rule or input string results in a proper error response with status code `400` and
message `"Invalid input"`. Furthermore, the response includes additional information to assist users in identifying
their mistake, providing more context on the specific error encountered.

### Rule-Based String Operations

I developed a mechanism to handle the specified string operations based on the provided rules. The supported operations
are:

- **Rule 1**: Reverse the string.
- **Rule 2**: Encode the string using the MD5 hash algorithm and represent it as a hexadecimal string.

The rules are applied sequentially, and each operation modifies the input string according to its definition. This
implementation allows for flexibility in accommodating potential future rule additions.

To add new rules, follow these steps:

1. Navigate to the `populateRules()` method within the `RuleBasedOperation` class in the codebase.

2. Inside the `populateRules()` method, add the implementation for the new rule. Ensure that the rule is defined
   following the required format, including the string operations to be performed.

3. After implementing the new rule, whitelist it to allow the service to recognize and execute it. Open
   the `application.properties` file and append the new rule to the `rule.whitelist` property. Ensure that the rule is
   correctly formatted and added to the whitelist.

By following these steps, you can seamlessly incorporate new rules into the service, enhancing its functionality while
maintaining compatibility and reliability.

### Backward Compatibility

To maintain backward compatibility, I retained the existing endpoint `/reply/{string}`. This endpoint continues to
function as before, returning the input string in a JSON object.

### Testability and Unit Tests

I implemented unit tests to ensure the correctness and reliability of the service, particularly focusing on individual
rule implementations and endpoint functionalities. This ensures that each component of the service behaves as expected
and facilitates easier debugging and maintenance.

[Github link to the project](https://github.com/TryingOutSomething/AparTechnologies-Assignment/)

## Build and Run the Project

To build the project, simply run the following command in your terminal:

```bash
./gradlew build
```

This command will compile the source code, run tests, and package the application.

Once the build is successful, you can start the project by executing:

```bash
./gradlew bootRun
```

This command will start the application. Once the service is up and running, you can access the endpoints at localhost:
8080 to make requests to the service.