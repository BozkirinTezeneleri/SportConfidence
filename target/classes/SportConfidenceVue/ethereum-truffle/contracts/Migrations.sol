pragma solidity ^0.4.18;
contract player {
    string public _name;
    string public _surname;
    string public _birthDate;
    uint public _height;
    uint public _weight;
    string public _contractTimeEnd;
    string public _contractTimeStart;
    string public _country;
    string public _sportClub;
    bool public _disabilityState;
    uint public _testimonial;

    function setPlayer(string name, string surname, string birthDate, uint height, uint weight, string contractTimeEnd, string contractTimeStart, string country, string sportClub, bool disabilityState, uint testimonial ) public {
        _name=name;
        _surname=surname;
        _birthDate=birthDate;
        _height=height;
        _weight=weight;
        _contractTimeEnd=contractTimeEnd;
        _contractTimeStart=contractTimeStart;
        _country=country;
        _sportClub=sportClub;
        _disabilityState=disabilityState;
        _testimonial=testimonial;
    }
}
