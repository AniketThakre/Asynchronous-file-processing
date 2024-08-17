**Asynchronous File Processing**

Here I have created an endpoint to get a file from the user and handle the processing of the file asynchronously. I have created two more endpoints which help to check the status of the processing and return the result.

The main end-point takes the file from the post request and checks for the file. If the file is not present it returns the response file not provided. Once the file is provided it returns the task id to the user and start the file processing asynchronously.

The users can take the task-id and hit the other endpoint to check the status of the file processing. Once the status turns into completed state, user can use the third endpoint to pull the result of the processing.

**This is an alternative to the Webhook solution which we can provide in a small stale project.**