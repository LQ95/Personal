CREATE FUNCTION getNthHighestSalary(N IN NUMBER) RETURN NUMBER IS
result NUMBER;
TYPE salaryarray IS VARRAY(2000) of NUMBER(38);
CURSOR salaries IS
        SELECT Salary,Id FROM Employee ORDER BY Salary DESC;
sal salaries%ROWTYPE;
salaryindex NUMBER;
lowerloop NUMBER;
lowest NUMBER;
arr salaryarray := salaryarray();
highestpaying salaryarray := salaryarray();
BEGIN
    /* Write your PL/SQL query statement below */
    
    result := NULL;
    salaryindex:=1;
    OPEN salaries;
    LOOP
        FETCH salaries INTO sal;
        EXIT WHEN salaries%NOTFOUND;
        arr.extend;
        arr(salaryindex):=sal.Salary;
        salaryindex:=salaryindex+1;
    END LOOP;
    CLOSE salaries;
        IF N <= arr.COUNT THEN
        result:=NULL;
        lowerloop:=1;
        highestpaying.extend;
        highestpaying(1):=arr(1);
        lowest:=1;
            LOOP
                EXIT WHEN lowerloop>arr.count;
                    IF arr(lowerloop)<highestpaying(lowest) THEN
                    lowest:=lowest+1;
                    highestpaying.extend;
                    highestpaying(lowest):=arr(lowerloop);
                    END IF;
                lowerloop:=lowerloop+1;
            END LOOP;
            
        END IF;
        IF N<=highestpaying.COUNT THEN
            result:=highestpaying(N);
        END IF;
    RETURN result;
END;