type Props = {
  specs: {
    screenSize: string;
    storage: string;
    mainCamera: string;
    frontCamera: string;
    nfc: boolean;
  };
};

const ProductSpecs = ({ specs }: Props) => {
  return (
    <div className="bg-white p-4 rounded shadow">
      <h2 className="text-lg font-semibold mb-4">Especificações</h2>
      <div className="grid grid-cols-2 gap-4 text-sm">
        <p>
          <strong>Tela:</strong> {specs.screenSize}
        </p>
        <p>
          <strong>Memória:</strong> {specs.storage}
        </p>
        <p>
          <strong>Câmera Principal:</strong> {specs.mainCamera}
        </p>
        <p>
          <strong>Frontal:</strong> {specs.frontCamera}
        </p>
        <p>
          <strong>NFC:</strong> {specs.nfc ? "Sim" : "Não"}
        </p>
      </div>
    </div>
  );
};

export default ProductSpecs;
