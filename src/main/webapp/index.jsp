<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Product Discount Calculator</title>
  <style>
    body{font-family:Arial,sans-serif;background:#f4f7fb;display:flex;justify-content:center;padding-top:70px}
    main{background:white;padding:32px;border-radius:10px;box-shadow:0 5px 22px #0001;width:380px;max-width:90vw}
    label{display:block;margin-top:16px;font-weight:bold}input{box-sizing:border-box;width:100%;padding:11px;margin-top:7px;border:1px solid #cbd5e1;border-radius:5px}
    button{margin-top:22px;padding:12px;background:#1b2a7a;color:white;border:0;border-radius:5px;width:100%;cursor:pointer}
  </style>
</head>
<body>
<main>
  <h2>Product Discount Calculator</h2>
  <form action="display-discount" method="POST">
    <label for="description">Product Description</label>
    <input id="description" name="description" type="text" required maxlength="200">
    <label for="listPrice">List Price</label>
    <input id="listPrice" name="listPrice" type="number" min="0" step="any" required>
    <label for="discountPercent">Discount Percent (%)</label>
    <input id="discountPercent" name="discountPercent" type="number" min="0" max="100" step="any" required>
    <button type="submit">Calculate Discount</button>
  </form>
</main>
</body>
</html>
