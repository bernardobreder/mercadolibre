const RelatedProducts = () => {
    return (
      <div className="mt-6">
        <h2 className="text-lg font-semibold mb-2">Produtos relacionados</h2>
        <div className="grid grid-cols-2 md:grid-cols-3 gap-4">
          {[1, 2, 3].map((i) => (
            <div key={i} className="bg-white rounded shadow p-2 text-sm">
              <img
                src={`https://via.placeholder.com/150?text=Produto+${i}`}
                alt={`Produto ${i}`}
                className="rounded mb-2"
              />
              <p>Produto Exemplo {i}</p>
              <p className="text-green-600 font-bold">$399</p>
            </div>
          ))}
        </div>
      </div>
    );
  };
  
  export default RelatedProducts;
  