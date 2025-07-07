const PaymentMethods = () => {
  return (
    <div className="bg-white p-4 rounded shadow">
      <h3 className="font-semibold mb-2">Meios de pagamento</h3>
      <p className="text-green-600 font-bold">Até 12x sem juros</p>
      <p className="text-sm text-gray-600 mt-2">
        Cartões de crédito, débito e boleto.
      </p>
      <ul className="mt-2 text-sm">
        <li>Visa, Mastercard, Elo</li>
        <li>Pix, Boleto, PagSeguro</li>
      </ul>
      <a href="#" className="text-blue-600 text-sm mt-2 block">
        Ver mais opções
      </a>
    </div>
  );
};

export default PaymentMethods;
