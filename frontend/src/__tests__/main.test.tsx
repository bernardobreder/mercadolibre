import { vi, test } from "vitest";

// Mock do App (evita side effects visuais)
vi.mock("../App", () => ({
  default: () => <div>Mocked App</div>,
}));

test("main.tsx deve renderizar sem erro", async () => {
  const root = document.createElement("div");
  root.id = "root";
  document.body.appendChild(root);

  // Importa main.tsx após injetar o #root
  await import("../main");
});
