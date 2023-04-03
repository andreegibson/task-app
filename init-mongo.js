db = new Mongo().getDB("admin");
db.auth("admin", "password");
db = db.getSiblingDB("taskdb");
db.createUser({
    user: "app",
    pwd: "password",
    roles: [
        {
            role: "readWrite",
            db: "taskdb",
        },
    ],
});

//////////////////////////////////////////////////////////
// Tasks
//////////////////////////////////////////////////////////
db.createCollection("tasks");
db.tasks.insertOne({"name":"Do Stuff","description":"Seriously, do something."});