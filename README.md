# Spring-Batch

In Spring Batch, 
    * a job consists of many steps 
        - each step consists of a task (ETL - Extract Transfor Load, READ-PROCESS-WRITE)
    * OR single operation task (tasklet).

“READ” data from the resources (feed file, csv files, xml or database).Spring Batch provides many made Classes to read/write CSV, XML and database.

A Job has Many Steps.
Each Step has a task (read-process-write) or a Tasklet.

The steps can be chained together to run as a job.
Job = {Step 1 -> Step 2 -> Step 3} (Chained together) 

Write a Job that does the following :-

Step 1 – Read CSV file from resource/feedfile folder, process it, by doing String.toUpperCase to all the strings, write it to DB.
Step 2 – Read CSV files from a Folder, process, write it to the database and keep a copy of the file in archive dir.
Step 3 – Create a tasklet to delete the files from feedfile folder.
Step 4 – Read data from a database, process the columns and generate a report in XML format in reports folder. write it to folder C.
Step 5 – Write a tasklet to attach the report in an email and send it to a group.