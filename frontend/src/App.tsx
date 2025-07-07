import { useEffect, useState } from "react";
import ProductMain from "./components/ProductMain.tsx";
import ProductSpecs from "./components/ProductSpecs";
import ProductDescription from "./components/ProductDescription";
import SellerInfo from "./components/SellerInfo";
import PaymentMethods from "./components/PaymentMethods.tsx";
import ProductStock from "./components/ProductStock.tsx";
import ProductRating from "./components/ProductRating.tsx";

function App() {
  const [produto, setProduto] = useState<any>(null);

  useEffect(() => {
    fetch("http://localhost:8080/api/produtos/1")
      .then((res) => res.json())
      .then((data) => setProduto(data))
      .catch((err) => console.error("Erro ao buscar produto", err));
  }, []);

  if (!produto) return <p>Carregando...</p>;

  return (
    <div className="bg-gray-100 min-h-screen text-gray-800">
      <div className="max-w-6xl mx-auto p-4 grid grid-cols-1 lg:grid-cols-3 gap-6">
        <div className="lg:col-span-2 space-y-6">
          <ProductMain nome={produto.nome} preco={produto.preco} />
          <ProductSpecs specs={produto.specs} />
          <ProductDescription descricao={produto.descricao} />
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
