<html>
<body>

<%-- LInes 12-17, used JSP scriptlet to declare and initialize the variables by request.getParameter methoda to retreieve
     when the user entered in the html page for the loan info. It will also be used to do calculations for the loan such
     as loan amount, annual interest rate number of years, monthly interest rate, monthly payment, and total payment. --%>
<%
    double loanAmount = Double.parseDouble(request.getParameter("loanAmount"));
    double annualInterestRate = Double.parseDouble(request.getParameter("annualInterestRate"));
    double numberOfYears = Integer.parseInt(request.getParameter("numberOfYears"));
    double monthlyInterestRate = annualInterestRate / 1200;
    double monthlyPayment = loanAmount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12));
    double totalPayment = monthlyPayment * numberOfYears * 12;
%>

<%-- Lines 20-22, used the JSP expression to display the calculation done in the JSP scriptlet. Loan amount, annual
     interest rate, and number of years will be displayed when the user ahve click the 'Submit' button in the first page (on the htmpl page) --%>
<b> <%-- To make the text bold (On the Programming Assignment 37.5 the textbook have only the loan amount, annual interest rate
         and number of years bold, but not the monthly and total payment --%>
    Loan Amount: <%= loanAmount %><br>
    Annual Interest Rate: <%= annualInterestRate %><br>
    Number of Years: <%= numberOfYears %><br>
</b>

<%--Lines 27-28, used the JSP expression to retrieves the monthly Payment and total Payment from the JSP scriptlet to
    display the user monthtly payment and total payment --%>
    Monthly Payment: <%= monthlyPayment %><br>
    Total Payment: <%= totalPayment %><br>

</body>
</html>