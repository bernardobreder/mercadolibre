import { useEffect, useState } from "react";
import ProductMain from "./components/ProductMain.tsx";
import ProductSpecs from "./components/ProductSpecs";
import ProductDescription from "./components/ProductDescription";
import SellerInfo from "./components/SellerInfo";
import PaymentMethods from "./components/PaymentMethods.tsx";
import ProductStock from "./components/ProductStock.tsx";
import ProductRating from "./components/ProductRating.tsx";
import getProduct, { Product } from "./services/api";
import Product from "./types/Product.ts";

import "./styles/index.css";
import "./styles/App.css";

function App() {
  const [product, setProduct] = useState<Product | null>(null);

  useEffect(() => {
    getProduct(1).then(setProduct).catch(console.error);
  }, []);

  if (!product) return <p>Carregando...</p>;

  return (
    <div className="main-panel bg-white min-h-screen text-gray-800">
      <div className="max-w-6xl mx-auto p-4 grid grid-cols-1 lg:grid-cols-3 gap-6">
        <div className="lg:col-span-2 space-y-6">
          <ProductMain name={product.name} price={product.price} />
          <ProductSpecs specs={product.specs} />
          <ProductDescription description={product.description} />
        </div>
        <div className="space-y-6">
          <SellerInfo />
          <PaymentMethods />
          <ProductStock />
          <ProductRating />
        </div>
      </div>
    </div>
  );
}

export default App;
