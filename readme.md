FunProxy
========

This project has just begun. My idea was to make a very simple self-configuring network proxy
that knew how to periodically check in with a web-service in order to discover service endpoints.

At the moment it's just a jumble of unconnected features which when joined together might do what I want.
Features such as:

* Decode JSON
* Produce JSON
* Query HTTP
* Serve HTTP
* Periodically run an activity
* Rewrite a URL
* Test a web-proxy