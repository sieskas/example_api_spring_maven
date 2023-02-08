Feature: Test the Invoice API

  Scenario Outline: Adding an Invoice
    Given the user is authenticated
    When the user sends a POST <request> to invoices
    Then the system will create the invoice and return the invoice number with <http_code>

    Examples:
      | case         | request             | http_code |
      | Nominal case | invoiceRequest.json | 201       |
