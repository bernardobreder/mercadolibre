type Props = {
  specs: {
    tela: string;
    memoria: string;
    cameraPrincipal: string;
    frontal: string;
    nfc: boolean;
  };
};

const ProductSpecs = ({ specs }: Props) => {
  return (
    <div className="bg-white p-4 rounded shadow">
      <h2 className="text-lg font-semibold mb-4">Especificações</h2>
      <div className="grid grid-cols-2 gap-4 text-sm">
        <p>
          <strong>Tela:</strong> {specs.tela}
        </p>
        <p>
          <strong>Memória:</strong> {specs.memoria}
        </p>
        <p>
          <strong>Câmera Principal:</strong> {specs.cameraPrincipal}
        </p>
        <p>
          <strong>Frontal:</strong> {specs.frontal}
        </p>
        <p>
          <strong>NFC:</strong> {specs.nfc ? "Sim" : "Não"}
        </p>
      </div>
    </div>
  );
};

export default ProductSpecs;
