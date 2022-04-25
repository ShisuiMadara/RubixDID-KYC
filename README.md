# RubixDID-KYC
<p>
A decentralised Know Your Customer (KYC) service based on Rubix blockchain Decentralised Identity (DID) based on NLSS protocol and self sovereign identity. The service is hosted on Interplanetary File System (IPFS).
</p>

<br>
<h1> Technology Used </h1>
<br>
<ul>
  <li>Rubix DID</li>
  <li>IPFS</li>
  <li>Java</li>
  <li>Maven</li>
  <li>ASP.NET</li>
  <li>Razor Pages</li>
</ul>

<br>
<h1> Properties </h1>
<br>
<ul>
  <li>Being a decentralised service, the user data is never stored and DID token is based only on the hash value of user information.</li>
  <li>The user is provided with their DID hash as well as the DID created image.</li>
  <li>The uniqueness of the data is ensured by SHA256 hash and the NLSS protocol, thus guaranteeing no breach of identity.</li>
  <li>The DID data is always available on IPFS and thus is easily assessible by the user.</li>
</ul>

<br>
<h1>Usage Instructions</h1>
<br>

<ol>
  <li>Set up your IPFS server and initialise using <em>ipfs daemon</em> command in terminal. </li>
  <li>Set up and run the Rubix SDK https://learn.rubix.net/did/. </li>
  <li>Install and run ASP.NET dependiencies along with java and go langugage.</li>
  <li>Install Maven and the Rubix dependencies. </li>
  <li>
    Access the web page, user is provided with two options :
    <br>
    <ul>
      <li><b>Registration : </b> Here the user can register using his Bio Data (Adhaar Number) and general information.</li>
      <li><b>Verification : </b> User has to provide his creadientials along with his unique DID hash value. The service then cross checks using the hash value of the provided data and user DID.</li>
    </ul>
  </li>
</ol>
 
<br>
  <h1>Resources</h1>
  
  <ul>
  <li>https://learn.rubix.net/did/</li>
  <li>https://greg.jeanmart.me/2019/08/14/managing-storage-in-a-java-application-with-ipfs/</li>
  
  </ul>
  
  
  

