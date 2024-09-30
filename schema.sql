CREATE TABLE Voter (
    VoterID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100),
    DateOfBirth DATE,
    Address VARCHAR(255),
    Email VARCHAR(100) UNIQUE,
    PhoneNumber VARCHAR(15),
    RegisteredDate DATE,
    VoterStatus ENUM('Active', 'Suspended'),
    PasswordHash VARCHAR(255) -- Assuming hashed passwords for security
);

CREATE TABLE Election (
    ElectionID INT PRIMARY KEY AUTO_INCREMENT,
    Title VARCHAR(255),
    Description TEXT,
    StartDate DATE,
    EndDate DATE,
    ElectionStatus ENUM('Upcoming', 'Ongoing', 'Completed')
);


CREATE TABLE Candidate (
    CandidateID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100),
    PartyAffiliation VARCHAR(100),
    Bio TEXT,
    ElectionID INT, -- Foreign key from Election
    FOREIGN KEY (ElectionID) REFERENCES Election(ElectionID) ON DELETE CASCADE
);

CREATE TABLE Vote (
    VoteID INT PRIMARY KEY AUTO_INCREMENT,
    ElectionID INT, -- Foreign key from Election
    VoterID INT,    -- Foreign key from Voter
    CandidateID INT, -- Foreign key from Candidate
    Timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (ElectionID) REFERENCES Election(ElectionID) ON DELETE CASCADE,
    FOREIGN KEY (VoterID) REFERENCES Voter(VoterID) ON DELETE CASCADE,
    FOREIGN KEY (CandidateID) REFERENCES Candidate(CandidateID) ON DELETE CASCADE,
    UNIQUE (ElectionID, VoterID) -- Ensure one voter votes once per election
);

CREATE TABLE Administrator (
    AdminID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100),
    Email VARCHAR(100) UNIQUE,
    Role ENUM('SuperAdmin', 'ElectionManager'),
    PhoneNumber VARCHAR(15)
);


CREATE TABLE Ballot (
    BallotID INT PRIMARY KEY AUTO_INCREMENT,
    ElectionID INT, -- Foreign key from Election
    VoterID INT,    -- Foreign key from Voter
    IsSubmitted BOOLEAN DEFAULT FALSE,
    CreationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (ElectionID) REFERENCES Election(ElectionID) ON DELETE CASCADE,
    FOREIGN KEY (VoterID) REFERENCES Voter(VoterID) ON DELETE CASCADE
);



-- Example Data Insertion

-- Insert a voter
INSERT INTO Voter (Name, DateOfBirth, Address, Email, PhoneNumber, RegisteredDate, VoterStatus, PasswordHash)
VALUES ('John Doe', '1990-05-10', '123 Elm St', 'john.doe@example.com', '555-1234', CURDATE(), 'Active', 'hashedpassword');

-- Insert an election
INSERT INTO Election (Title, Description, StartDate, EndDate, ElectionStatus)
VALUES ('Presidential Election 2024', 'National election for president', '2024-11-01', '2024-11-02', 'Upcoming');

-- Insert a candidate
INSERT INTO Candidate (Name, PartyAffiliation, Bio, ElectionID)
VALUES ('Alice Johnson', 'Democratic Party', 'Bio for Alice', 1);

-- Cast a vote
INSERT INTO Vote (ElectionID, VoterID, CandidateID)
VALUES (1, 1, 1);

-- Insert an administrator
INSERT INTO Administrator (Name, Email, Role, PhoneNumber)
VALUES ('Admin Name', 'admin@example.com', 'SuperAdmin', '555-5678');





-- To check how many votes a candidate has received:
SELECT Candidate.Name, COUNT(Vote.VoteID) AS TotalVotes
FROM Vote
JOIN Candidate ON Vote.CandidateID = Candidate.CandidateID
WHERE Vote.ElectionID = 1
GROUP BY Candidate.CandidateID;


-- To find all elections a specific voter has participated in:
SELECT Election.Title, Election.StartDate, Election.EndDate
FROM Election
JOIN Vote ON Election.ElectionID = Vote.ElectionID
WHERE Vote.VoterID = 1;




ElectionController Endpoints:

GET /api/elections: Fetch all elections.
GET /api/elections/{id}: Fetch an election by ID.
POST /api/elections: Create or update an election.
DELETE /api/elections/{id}: Delete an election by ID.
CandidateController Endpoints:

GET /api/candidates: Fetch all candidates.
GET /api/candidates/{id}: Fetch a candidate by ID.
GET /api/candidates/election/{electionId}: Fetch candidates by election ID.
POST /api/candidates: Create or update a candidate.
DELETE /api/candidates/{id}: Delete a candidate by ID.
VoteController Endpoints:

GET /api/votes: Fetch all votes.
GET /api/votes/{id}: Fetch a vote by ID.
POST /api/votes: Cast a vote.
GET /api/votes/election/{electionId}: Fetch votes by election ID.
GET /api/votes/candidate/{candidateId}/count: Count votes for a candidate.
DELETE /api/votes/{id}: Delete a vote by ID.
BallotController Endpoints (if used):

GET /api/ballots: Fetch all ballots.
GET /api/ballots/{id}: Fetch a ballot by ID.
POST /api/ballots: Create or update a ballot.
DELETE /api/ballots/{id}: Delete a ballot by ID.

