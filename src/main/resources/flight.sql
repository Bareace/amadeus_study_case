-- Airports Table
CREATE TABLE Airports (
    ID INT PRIMARY KEY,
    City VARCHAR(255) NOT NULL
);

-- Flights Table
CREATE TABLE Flights (
    ID INT PRIMARY KEY,
    DepartureAirportID INT,
    ArrivalAirportID INT,
    DepartureDateTime DATETIME,
    ReturnDateTime DATETIME,
    Price DECIMAL(10, 2),
    FOREIGN KEY (DepartureAirportID) REFERENCES Airports(ID),
    FOREIGN KEY (ArrivalAirportID) REFERENCES Airports(ID)
);
