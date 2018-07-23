const fetch = require('node-fetch');
const { ApolloServer, gql } = require('apollo-server');

const baseUrl = "http://localhost:4567";
const employee = {
    getAllEmployee(){
    return fetch(baseUrl+'/employees').then(res=>res.json()).then(res=>{return res});
  }
}

const typeDefs = gql`
  
  type Employee {
    id: Int,
    fname: String,
    lname:String,
    email:String
  }

  # The "Query" type is the root of all GraphQL queries.

  type Query {
    employees: [Employee]
  }
`;

// Resolvers define the technique for fetching the types in the
// schema.  We'll retrieve employees from the "employee" 

const resolvers = {
  Query: {
    employees: () => employee.getAllEmployee(),
  },
};

// In the most basic sense, the ApolloServer can be started
// by passing type definitions (typeDefs) and the resolvers
// responsible for fetching the data for those types.
const server = new ApolloServer({ typeDefs, resolvers });

// This `listen` method launches a web-server.  Existing apps
// can utilize middleware options, which we'll discuss later.
server.listen().then(({ url }) => {
  console.log(`🚀  Server ready at ${url}`);
});