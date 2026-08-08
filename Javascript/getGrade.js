function getGrade(score){
    if(score <= 100 && score >= 90) return "A+";
    else if(score <= 89 && score >= 80) return "A";
     else if(score <= 79 && score >= 70) return "B";
    else if(score<=69 && score >= 60) return "C";
    else if(score<=59 && score >= 33) return "D";
    else if(score<=32 && score >= 0) return "Fail";
    else return "invalid marks";



}
console.log(getGrade(100));